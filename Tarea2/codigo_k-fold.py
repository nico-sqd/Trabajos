import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
import seaborn
seaborn.set()
print('¡Bibliotecas Listas!')

def k_fold(datos, k):
    df = datos
    N = datos.shape[0]
    print(N)
    min_index = 0
    folds = {}
    for index in range(0, k):
        if (index + 1) == k:
            max_index = (int(N/k)*(index + 1)) + (N%k) -1
        else:
            max_index = (int(N/k)*(index + 1))
        print(max_index)
        testeo = df.iloc[min_index:max_index]
        entrenamiento = df.drop(labels=testeo.index, axis=0)
        folds[index] = {"entrenamiento": entrenamiento, "testeo": testeo}
        min_index = max_index
    return folds

k_folds=k_fold(df,4)

k_folds[3]

##otro codigo jeje

##df = np.array_split(df,5)