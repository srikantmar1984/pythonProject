# my_name = "Srikant"
# for i in my_name:
#     print(i)

# using Range function use of for loop.

#n = int(input("enter any integer value"))
# for i in range(1,11):
#     c = n*i
#     print(n,"*",i,"=",c)

# for i in range(0,(n+1)):
#     for j in range(i):
#         print("*",end = '')
#     print()

# name = input("enter your name")
# i = 0
# while i < len(name):
#     if name[i] == 'r':
#         i += 1
#         continue
#     print(name[i])
#     i += 1

n = int(input("enter no of lines"))
i = 0
while n > i:
    j = n
    while j > i:
        print("*",end ='')
        j -= 1
    print()
    n -= 1






