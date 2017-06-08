from flask import Flask
from flask_bootstrap import Bootstrap

app = Flask(__name__)
Bootstrap(app)

@app.route('/')
def hello_world():
	return 'Hello LsyManagement'

if __name__ == '__main__':
	app.run(host='0.0.0.0')