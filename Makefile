.PHONY: repl build build-action watch deploy serve

repl:
	clj

# TODO I'm confused by why the action has to be in different order
build-action:
	clojure -X:build
	npm install
	npm run release
	cp -r resources/* _site/
	touch _site/.nojekyll

build:
	npm install
	npm run release
	clj -X:build
	cp -r resources/* _site/
	touch _site/.nojekyll

# TODO idk what to change about this one too
watch:
	while true; do \
		BUILD_ENV=development npm run release; \
		inotifywait -r -e modify src/gaiwan resources; \
	done

dev:
	npm run dev

stage: build
	npm run release
	rsync -a _site/ ark:/srv/ox/gaiwan.co

deploy: build
	npm run release
	cd _site && git add --all && git commit -m "Publishing to gh-pages" && cd ..
	git push origin gh-pages

serve:
	clj -X:serve

develop:
	clj -X:develop
