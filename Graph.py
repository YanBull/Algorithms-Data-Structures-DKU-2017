import turtle
import random
import math
import sys
myWin= turtle.Screen()
tr=turtle.Turtle()
tr1=turtle.Turtle()
X=[]
k1=0
k2=0
b1=0
b2=0
xcor=0
ycor=0
R=0
p=0
f=0
a=0
b=0
c=0
coordinates=dict()
tr.speed(0)
tr1.speed(0)
for i in range(15):
        x=random.randrange(-350,350)
        y=random.randrange(-350,350)
        X.append(x)
        coordinates.update({X[i]:y})
        tr1.penup()
        tr1.goto(x,y)
        tr1.pendown()
        tr1.dot(10)
        tr1.write(i)
        x=0
        y=0
X1=list(X)
coordinates1=dict(coordinates)
def draw_graph():
        u=0
        for i in range(len(X)):
            for j in range(len(X)):
                for k in range(len(X)):
                        f=0
                        if i==j or j==k or i==k:
                            break
                        tr.penup()

                        if coordinates[X[j]]-coordinates[X[i]]==0:
                                k1=sys.maxsize
                        else:
                                k1=(X[i]-X[j])/(coordinates[X[j]]-coordinates[X[i]])
                        if coordinates[X[k]]-coordinates[X[j]]==0:
                                k2=sys.maxsize
                        else:
                                k2=(X[j]-X[k])/(coordinates[X[k]]-coordinates[X[j]])

                        b1=(coordinates[X[i]]+coordinates[X[j]])/2-k1*(X[i]+X[j])/2
                        b2=(coordinates[X[j]]+coordinates[X[k]])/2-k2*(X[j]+X[k])/2
                            
                        xcor=(b2-b1)/(k1-k2)
                        ycor=(k1*b2-b1*k2)/(k1-k2)

                        tr.goto(xcor,ycor)
                        
                        p=(math.sqrt((X[i]-X[j])**2+(coordinates[X[i]]-coordinates[X[j]])**2)+math.sqrt((X[j]-X[k])**2+(coordinates[X[j]]-coordinates[X[k]])**2)+math.sqrt((X[i]-X[k])**2+(coordinates[X[i]]-coordinates[X[k]])**2))/2
                        a=math.sqrt((X[i]-X[j])**2+(coordinates[X[i]]-coordinates[X[j]])**2)
                        b=math.sqrt((X[j]-X[k])**2+(coordinates[X[j]]-coordinates[X[k]])**2)
                        c=math.sqrt((X[i]-X[k])**2+(coordinates[X[i]]-coordinates[X[k]])**2)
                        R=(a*b*c)/(4*math.sqrt(p*(p-a)*(p-b)*(p-c)))
                        for l in range(len(X1)):
                            if R>tr.distance(X1[l],coordinates[X1[l]]) and X1[l]!=X[i] and X1[l]!=X[j] and X1[l]!=X[k]:
                                f=1
                                break
                        if f==1:
                            break
                        tr.setpos(X[i],coordinates[X[i]])
                        tr.pendown()
                        tr.goto(X[j],coordinates[X[j]])
                        tr.goto(X[k],coordinates[X[k]])
        X.remove(X[u])
        u+=1
        draw_graph()
draw_graph()
                   
