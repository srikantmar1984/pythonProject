# Call by reference in Python

def changelist(lst):
    lst.append(10)
    lst.append(40)
    print("list inside function:",lst)

list1 = ['a','b','c','d']
print("list outside function :",list1)
changelist(list1)

#after git commit
