import torch
from torch import nn
from torch.utils.data import DataLoader
import pandas as pd
import psycopg2 as ps


DB_CONNECTR = {
    "host" : "localhost",
    "port":5432,
    "dbname":"peptide_db",
    "user":"admin",
    "password":"secret_code"
}

def get_our_db_lungs():
    connect =  ps.connect(**DB_CONNECTR)
    query = "SELECT sequence, class FROM peptides_l"
    df = pd.read_sql_query(query,connect)
    connect.close()


    return df

def get_our_db_breast():
    connect =  ps.connect(**DB_CONNECTR)
    query = "SELECT sequence, class FROM peptides_b"
    df = pd.read_sql_query(query,connect)
    connect.close()


    return df





translation = {
    'padding':0,
    'A':1,
    'W':2,
    'K':3,
    'E':4,
    'F':5,
    'I':6,
    'T':7,
    'C': 8,
    'D': 9,
    'L': 10,
    'M': 11,
    'N': 12,
    'P': 13,
    'Q': 14,
    'R': 15,
    'S': 16,
    'G': 17,
    'V': 18,
    'H': 19,
    'Y': 20,
}


