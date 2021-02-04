#https://konklone.io/json/  json to csv

from cherrypicker import CherryPicker
import json
import pandas as pd

with open('file.json') as file:
    data = json.load(file)

picker = CherryPicker(data)
flat = picker['PICKEDTWEETS'].flatten().get()
notflat = picker['PICKEDTWEETS'].get()
df = pd.DataFrame(flat)
df.to_csv('output.csv', index=False)
