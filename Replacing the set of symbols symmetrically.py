import random
a=[]
temp=0
for i in range(40):
    a.append(random.randrange(97,122))
for i in range(len(a)):
    a[i]=chr(a[i])
print(a)
for i in range(len(a)):
    a[i]=ord(a[i])
for i in range(len(a)//2):
    for j in range(len(a), len(a)//2, -1):
        if i==(39-j):
            temp=a[i]
            a[i]=a[j]
            a[j]=temp
            temp=0
for i in range(len(a)):
    a[i]=chr(a[i])
print()
print()
print(a)
