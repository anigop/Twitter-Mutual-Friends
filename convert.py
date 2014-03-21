import json

def read_input():
	try:	
		with open('sampledata.json') as myfile:
			json_stream  = myfile.read()
			json_map = json.loads(json_stream)
			for rec in json_map:
				rec["followers"] = map(str,rec["followers"])
				rec["id"] = str(rec["id"])
			return json_map
	except IOError:
	    print "Error while reading input file"
	    return None
def main():
	json_map = read_input()
	for rec in json_map:
		print(str(rec["followers"])+"   "+str(rec["id"]))
	try:
		with open('inputs-large.json','w') as myfile:
			json.dump(json_map,myfile)
	except IOError:
	    print "Could not open file for write"


if __name__=='__main__':
	main()
