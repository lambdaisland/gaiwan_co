# Gaiwan

Landing page for https://gaiwan.co

## Running locally

This project uses [Parcel](https://parceljs.org/) to provide a nice local development setup and to bundle our assets.

`Parcel` is usually run locally through a global installation but we have included it in our `package.json` so that we can build the project programatically for CI deployment and also to use a custom directory more in tune with our Clojure culture (`/resources/public`) for our static assets.

Run `npm install` to install the project development dependencies and `npm run dev` to run a local development server with asset auto-reload and Hot Module Replacement.

For more information, please see https://parceljs.org/getting_started.html

## Building for deployment

Running `npm run build` will output a `/dist` directory with the website ready for deployment and this is the directory that should be served.
