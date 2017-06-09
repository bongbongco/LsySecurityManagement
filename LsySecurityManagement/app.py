from flask import Flask, render_template
from flask_bootstrap import Bootstrap

app = Flask(__name__)
app.debug = True
Bootstrap(app)

@app.route('/')
def hello_world():
	return 'Hello LsyManagement'

@app.route('/login')
def login():
	return render_template('login.html', error="rander template test")

@app.route('/base')
def test():
	return render_template('base.html', error="rander template test")

if __name__ == '__main__':
	app.run(host='0.0.0.0')