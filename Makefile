coverage:
	cd jeorg-javascript-algorithms/jeorg-javascript-alg-hanoi-towers && npm run coverage
	cd jeorg-javascript-algorithms/jeorg-javascript-alg2-floyd-tortoise-hare && npm run coverage
	cd jeorg-javascript-algorithms/jeorg-javascript-alg3-brent-tortoise-hare && npm run coverage
	cd jeorg-javascript-algorithms/jeorg-javascript-alg4-activity-selector && npm run coverage
	coverage run --source=jeorg-python-algorithms -m pytest && coverage json
coverage-all: coverage
	mvn clean install jacoco:prepare-agent install package jacoco:report
install:
	cd jeorg-javascript-algorithms/jeorg-javascript-alg-hanoi-towers && yarn && yarn add jest --dev
	cd jeorg-javascript-algorithms/jeorg-javascript-alg2-floyd-tortoise-hare && yarn && yarn add jest --dev
	cd jeorg-javascript-algorithms/jeorg-javascript-alg3-brent-tortoise-hare && yarn && yarn add jest --dev
	cd jeorg-javascript-algorithms/jeorg-javascript-alg4-activity-selector && yarn && yarn add jest --dev
