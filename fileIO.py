# fileptr = open("hello.py","w")
# if fileptr:
#      print("file is open successfully")
#
# fileptr.close()



with open("hello.py",'r') as fl:
    cont = fl.read();

print(cont)

