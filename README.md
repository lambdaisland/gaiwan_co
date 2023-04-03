# Gaiwan GmbH

This repository consists the code for our website https://gaiwan.co

We are a provider of technological expertise grown out of the consulting and development work of Arne Brasseur.

## Tech stack

We love Clojure, and this site is built with it! 

We're using simple, standard, clojure tools and libraries to build this. Nothing fancy :)

##  Architechture

All the source files are located in `src/gaiwan` directory and static resources
in the `resources` directory.

The site works as a dynamic server rendered site on localhost, then we use [reitit-jaatya](https://github.com/lambdaisland/reitit-jaatya) to create a frozen static build of this site.

The frozen site gets generated inside a `_site` directory. This directory is added to
gitingore because we don't want to mix the build and source history. Therefore
we commit the `_site` directory to a `gh-pages` branch using a nifty feature of
git called as worktrees.

Building and deploying happens automatically by pushing to `main`, thanks to GH Actions.

## Local development

Ensure you have Clojure CLI tools installed.

Use `cider-jack-in-clj` to launch a clojure repl (or `clj`)

and then run

```clojure
user => (go)
2022-05-02 18:03:35.951 INFO  lambdaisland.webstuff.bootstrap - {:integrant/starting {:profile :default, :key nil}, :line 58}
2022-05-02 18:03:35.961 INFO  lambdaisland.webstuff.http - {:server/starting {:port 9000, :rebuild-on-request? true}, :line 265}
:initiated
user => (browse)
true
```

This will start the server at http://localhost:9000

Everything is dynamic and REPL'able. When you're satisfied you can build the site by running

```clojure
user => (require '[co.gaiwan.site :as site])
user => (site/build)
```

or from the command line like so:

```bash
make build
```

This will run `npm run release` and generate a `_site` folder

The `resources` directory is copied to the final site as is.

### Frontend setup

Make sure you have latest npm deps installed using `npm install` and then open
up another terminal window and run:

```bash
# cd to project directory
npm run dev
```

This will start postcss watches and run a local server serving the `_site` directory on http://localhost:8001


## Deployment

The site is automatically deployed via a Github Actions workflow. Simply push
your changes to `main`, and the result will end up on the `gh-pages` branch,
which is what Github displays.

<!-- For first time deployment there is an extra step involved where you need to run the following commands: -->

<!-- ```bash -->
<!-- rm -rf _site -->
<!-- git worktree add -B gh-pages public origin/gh-pages -->
<!-- ``` -->

<!-- Once you're satisfied with the changes, deploy the site live by running: -->

<!-- ``` -->
<!-- make deploy -->
<!-- ``` -->

## Enhancements

Currently the setup is extremely simple and minimal. Everytime you make a change you need to rerun the build command. This is tiresome and we need to find a way to autobuild on file changes.

A problem is that the css/js assets are not being hashed. This can lead to caching issues. We can use `sha1sum` utility present on linux systems to build on this.

## License

TODO
