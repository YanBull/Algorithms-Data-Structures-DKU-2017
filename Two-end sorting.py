import random, sys
values=[]
for i in range(100):
        values.append(random.randint(100, 999))
print(values)

for i in range (50):
        for j in range(len(values)):
                mx=max(values)
        for k in range (len(values)):
                mn=min(values)
        print(mx,"-" , end=' ')
        print(mn)
        values.remove(mx)
        values.remove(mn)




    
    
