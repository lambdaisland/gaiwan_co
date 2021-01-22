.PHONY: repl build build-action watch deploy serve

repl:
	clj

build-action:
	clojure -X:build
	cp -r resources/* _site/
	cp resources/.nojekyll _site/

build:
	clj -X:build
	cp -r resources/* _site/
	cp resources/.nojekyll _site/

watch: build
	while true; do \
		inotifywait -r -e modify src/gaiwan resources; \
		make build ; \
	done

deploy: build
	cd _site && git add --all && git commit -m "Publishing to gh-pages" && cd ..
	git push origin gh-pages

serve:
	cd _site && python3 -m http.server --bin 0.0.0.0 8001
