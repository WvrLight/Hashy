input_string = """+-----------+-------+
| Word      | Count |
+-----------+-------+
| the       |   107 |
| RT        |    83 |
| #GameStop |    72 |
| and       |    49 |
| to        |    46 |
| a         |    40 |
| of        |    38 |
| is        |    36 |
| on        |    28 |
| in        |    25 |
+-----------+-------+
"""

import re, csv, sys
def pretty_table_to_tuples(input_str):
    lines = input_str.split("\n")
    num_columns = len(re.findall("\+", lines[0])) - 1
    line_regex = r"\|" + (r" +(.*?) +\|"*num_columns)
    for line in lines:
        m = re.match(line_regex, line.strip())
        if m:
            yield m.groups()

w = csv.writer(sys.stdout)
w.writerows(pretty_table_to_tuples(input_string))
