import pandas as pd
 
df_lodict = [
             {'year' : 2002, 'HostCountry' : 'Japan', 'Winner' : 'Brazil'},
             {'year' : 2006, 'HostCountry' : 'Germany', 'Winner' : 'Italy'},
             {'year' : 2010, 'HostCountry' : 'South Africa', 'Winner' : 'Spain'},
             {'year' : 2014, 'HostCountry' : 'Brazil', 'Winner' : 'Germany'},
            ]
data = pd.DataFrame(df_lodict)
