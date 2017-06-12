from flask import Flask, render_template
from flask_bootstrap import Bootstrap

app = Flask(__name__)
app.debug = True
Bootstrap(app)

@app.route('/')
@app.route('/index')
def index():
	return render_template('index.html')

@app.route('/login')
def login():
	return render_template('login.html')

@app.route('/task')
def task():
	return render_template('task.html')

if __name__ == '__main__':
	app.run(host='0.0.0.0')