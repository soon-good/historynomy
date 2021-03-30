#-*- coding:utf-8 -*-

import datetime
import json

import urllib3
from pymongo import MongoClient

date_formatter_yyyymmdd = '%Y%m%d'
date_formatter_yyyymm = '%Y%m'

COLUMN_LIST = [
        'STAT_NAME',  'STAT_CODE',  'ITEM_CODE1', 'ITEM_CODE2', 'ITEM_CODE3',
        'ITEM_NAME1', 'ITEM_NAME2', 'ITEM_NAME3', 'DATA_VALUE', 'TIME'
    ]

api_key = '--'


if __name__ == '__main__':
    korbank_url = "http://ecos.bok.or.kr/api/StatisticSearch/{}/json/kr/1/50000/028Y015/MM/196001/202103/1080000" \
        .format(api_key)

    print(" ####### request URL #######")
    print(korbank_url)

    http = urllib3.PoolManager()
    ret = http.request("GET", korbank_url, headers={'Content-Type': 'application/json'})

    # str_response = ret.data.decode('utf-8')
    str_response = ret.data
    dict_data = json.loads(str_response)

    arr_data = dict_data['StatisticSearch']['row']

    rows_for_insert = []
    mongo_client = MongoClient("mongodb://mongoadmin:1111@localhost:27039/")
    db_market_index = mongo_client['market_index']
    collection_kospi = db_market_index['kospi']

    for e in arr_data:
        # datetime 타입으로 변환 ( strptime :: str 'parse' time )
        e['TIME'] = datetime.datetime.strptime(e['TIME'], date_formatter_yyyymm)

        dict_dump = {
            'statDesc': e['STAT_NAME'],
            'midCategory': e['ITEM_CODE1'],
            'topCategory': e['STAT_CODE'],
            'dataName': 'KOSPI (월별,평균)',
            'dataValue': float(e['DATA_VALUE']),
            'time': e['TIME'].fromisoformat(e['TIME'].isoformat())
        }

        rows_for_insert.append(dict_dump)

    insert_data = collection_kospi.insert_many(rows_for_insert)
    print(insert_data.inserted_ids)
