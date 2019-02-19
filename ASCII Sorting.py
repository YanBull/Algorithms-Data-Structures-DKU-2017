import random
def sortbysum(a=[]):
    summ=0
    for i in range(len(a)):
        for j in range(len(a[i])):
            summ=summ+ord(a[i])
    return summ
        
a=[]
for i in range(50):
    a.append([])
    for j in range(3):
        a[i].append(random.randrange(97,122))

print(a)
for i in range(len(a)):
    for j in range(len(a[i])):
        a[i][j]=chr(a[i][j])
print("Array of random three-symbol words")
print(a)
print()
print()
a1=sorted(a)
print("Sorted in alphabet order")
print(a1)
print()
print()
a1.sort(key=sortbysum)
print("Sorted by words' overall ASCII value")
print(a1)
print()
print()
        
