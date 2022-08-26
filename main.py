"""
Function
"""


# def calculate(a, b):
#     total = 0
#     total = a + b

#     return total


# d_telephone = {'raju': 9497, 'srikant': 7528}
# n = calculate(19, 13)
# print("19_13:", n)
# n = calculate(34, 78)
# print("34_78:", n)



import pandas as pd
 
df_lodict = [
             {'year' : 2002, 'HostCountry' : 'Japan', 'Winner' : 'Brazil'},
             {'year' : 2006, 'HostCountry' : 'Germany', 'Winner' : 'Italy'},
             {'year' : 2010, 'HostCountry' : 'South Africa', 'Winner' : 'Spain'},
             {'year' : 2014, 'HostCountry' : 'Brazil', 'Winner' : 'Germany'}
            ]
data = pd.DataFrame(df_lodict)
data

