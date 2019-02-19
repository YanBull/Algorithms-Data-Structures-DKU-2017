import turtle
import math
myWin=turtle.Screen()
myPen=turtle.Turtle()
myPen.speed(0)
A=[]
B=[]
C=[]
D=[]
myPen.setheading(0)
myPen.goto(0,0)
myPen.left(320)
a=myPen.xcor()
def spiral(a,r,f):
    b=0
    for i in range(a):
       myPen.forward(r)
       myPen.left(f)
       b=b+1
       if b==90/f:
           myPen.right(280)
           r=r+0.1*r
           h=myPen.xcor()
           z=myPen.ycor()
           C.append(h)
           D.append(z)
       if b==180/f:
           myPen.setheading(320)
           r=r+0.05*r
           b=0
           g=myPen.xcor()
           c=myPen.ycor()
           A.append(g)
           B.append(c)

spiral(540,0.5,6)

#print(a,g,c)
myPen.goto(A[0],B[0])
myPen.penup()
myPen.goto(C[0],D[0])
myPen.pendown()
myPen.goto(C[len(C)-1],D[len(D)-1])
