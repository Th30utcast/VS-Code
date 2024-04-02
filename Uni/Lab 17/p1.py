import math as mt

class Point:
    def __init__(self, x , y ,z):
        self.x = x
        self.y = y
        self.z = z
    def __eq__(self, other):
        return self.x == other.x and self.y == other.y and self.z == other.z
    def __repr__(self):
        return f'Point({self.x},{self.y},{self.z})'
    def largest(self):
        return max(self.x,self.y,self.z)
    def norm(self):
        return int(mt.sqrt(self.x**self.x+self.y**self.y+self.z**self.z))
    def __abs__(self, other):
        return Point(self.y*other.z-self.z*other.y, self.z*other.x-self.x*other.z , self.x*other.y-self.y*other.x)
    def __add__(self,other):
        return Point(self.x+other.x , self.y+other.y , self.z+other.z)
    def __mul__(self, number):
        return Point(self.x*number , self.y*number , self.z*number)
    def __hash__(self):
        return hash((self.x,self.y,self.z))
p1 = Point(1,2,3)
p2 = Point(0,0,0)
#--------- List --------# 
print(f'List:')
l = [p1,p2]
for i in range(len(l)):
    for j in range(i + 1, len(l)):
        if l[i] == l[j]:
            print(f"Point {l[i]} is equal to Point {l[j]}")
print(f"L = {l}")
for point in l:
        print(f"{point}: {point.norm()}")
print(f'|Done List|')
#--------- Set ----------#
print(f'Set:')
s = {p1,p2}
print(f"is {p1} in the set? {p1 in s}")
print(f"is {p2} in the set? {p2 in s}")
print(" ".join(str(x) for x in s))
#--------- Set ----------#
#---------- mul ----------#
print(f'{p1} is now {p1*10}\n|Done Mult|')
#--------- mul -----------# 
