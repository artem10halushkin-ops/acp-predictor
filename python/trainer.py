import pandas as pd
import kagglehub
import os


path = kagglehub.dataset_download("anuragupadhyaya/anticancer-peptides-data-set")

csv_file_lungs = os.path.join(path, "ACPs_Lung_cancer.csv")
cvs_file_breast = os.path.join(path, "ACPs_Breast_cancer.csv")

file_lungs = pd.read_csv(csv_file_lungs)
file_breast = pd.read_csv(cvs_file_breast)


eng = create_engine("postgressql//admin:secret_code@db-5432/peptide_db")




