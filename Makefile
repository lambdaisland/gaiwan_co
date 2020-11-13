.PHONY: build dev

build:
	bb src/gaiwan/build.clj
	cp -r resources/* _site/

deploy: build
	cd _site && git add --all && git commit -m "Publishing to gh-pages" && cd ..
	git push origin gh-pages
