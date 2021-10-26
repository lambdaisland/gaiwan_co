.PHONY: repl build build-action watch deploy serve

repl:
	clj

build-action:
	clojure -X:build
	npm run release
	cp -r resources/* _site/
	cp resources/.nojekyll _site/

build:
	clj -X:build
	cp -r resources/* _site/
	cp resources/.nojekyll _site/

watch: build
	while true; do \
		BUILD_ENV=development make build ; \
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
	cd _site && python3 -m http.server --bin 0.0.0.0 8001
