#https://konklone.io/json/  json to csv
#https://towardsdatascience.com/how-to-export-pandas-dataframe-to-csv-2038e43d9c03


from cherrypicker import CherryPicker
import json
import pandas as pd

with open('file.json') as file:
    data = json.load(file)

picker = CherryPicker(data)
flat = picker['PICKEDTWEETS'].flatten().get()
#or flat = picker.flatten().get()
df = pd.DataFrame(flat)
#df.to_csv('output.csv', index=False)
df.to_csv('output.csv', encoding='utf-8')
