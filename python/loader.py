import pandas as pd
import kagglehub
import os


path = kagglehub.dataset_download("anuragupadhyaya/anticancer-peptides-data-set")

csv_file_lungs = os.path.join(path, "ACPs_Lung_cancer.csv")
cvs_file_breast = os.path.join(path, "ACPs_Breast_cancer.csv")

file_lungs = pd.read_csv(csv_file_lungs)
file_breast = pd.read_csv(cvs_file_breast)


eng = create_engine("postgresql://admin:secret_code@db:5432/peptide_db")

file_lungs.to_sql(name="peptides_l", con=eng , if_exists="replace" , index = False)
file_breast.to_sql(name="peptides_b",con=eng , if_exists="replace", index = False)



