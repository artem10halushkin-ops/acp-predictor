import torch
from sqlalchemy.dialects.oracle import dictionary
from torch import nn
from torch.utils.data import Dataset
import pandas as pd
import psycopg2 as ps
from sqlalchemy import create_engine
max_length = 20

eng = create_engine("postgresql://admin:secret_code@localhost:5432/peptide_db")

DB_CONNECTR = {
    "host": "localhost",
    "port": 5432,
    "dbname": "peptide_db",
    "user": "admin",
    "password": "secret_code"
}


def get_our_db_lungs():
    connect = ps.connect(**DB_CONNECTR)
    query = "SELECT sequence, class FROM peptides_l"
    df = pd.read_sql_query(query, connect)
    connect.close()
    return df


def get_our_db_breast():
    connect = ps.connect(**DB_CONNECTR)
    query = "SELECT sequence, class FROM peptides_b"
    df = pd.read_sql_query(query, connect)
    connect.close()
    return df




translation = {
        'padding': 0, 'A': 1,
        'W': 2, 'K': 3, 'E': 4,
        'F': 5, 'I': 6, 'T': 7,
        'C': 8, 'D': 9, 'L': 10,
        'M': 11, 'N': 12, 'P': 13,
        'Q': 14, 'R': 15, 'S': 16,
        'G': 17, 'V': 18, 'H': 19, 'Y': 20,
 }



class PeptideDataSet(Dataset):

    def padd_adjusting(self, n: int, sequence: list):
        pad = torch.zeros(n, dtype=torch.long)
        tensor_seq = torch.tensor(sequence[:n], dtype=torch.long)
        pad[:len(tensor_seq)] = tensor_seq
        return pad

    def __init__(self, df , trans_dict ,max_length):
        self.dataframe = df
        self.m_Length = max_length
        self.dictionary = trans_dict

    def __len__(self):
        return len(self.dataframe)

    def __getitem__(self, index):
        row = self.dataframe.iloc[index]
        seq = row['sequence']
        affect = row['class']
        tmp_list = []
        for letter in seq:
            tmp_list.append( self.dictionary.get(letter,0) )
        tmp_list = self.padd_adjusting( self.m_Length, tmp_list )

        target_tensor = torch.tensor(affect , dtype= torch.float32)
        return tmp_list , target_tensor










