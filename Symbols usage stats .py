import matplotlib.pyplot as plt
import sys
import numpy as np
import os.path

A=[]
bins=[]
bins2=[]


with open(r'C:\Program Files (x86)\Python37-32\LICENSE.txt') as f:
    for c in f.read():#Открыть исходный файл в режиме чтения
        A.append(c)#Расширять список А на каждый символ из файла
print(A)
f.close()
for i in range(len(A)):
    A[i]=ord(A[i]) # Каждый элемент списка прдеставить в виде кода ASCII
print(A)
for i in range(65,122):
    bins.append(i) # Создать список чисел от 65 до 122 (англ алфавит,
    bins2.append(0) #знаки препинания в кодировке ASCII)

hist,bins=np.histogram(A, bins)
width=0.6*(bins[1]-bins[0])
center=(bins[:-1]+bins[1:])/2
plt.bar(center, hist, width=width)
for i in range(len(bins)):
    try: #по оси ох нельзя использовать буквенные значения, однако можно
        bins2[i]=chr(bins[i])#добавить лейбл внизу гистограммы, с каждым символом
    except ValueError:
        pass      
plt.xlabel(bins2)
plt.show()

