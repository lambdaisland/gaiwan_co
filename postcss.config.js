module.exports = {
  plugins: {
    'postcss-import': {},
    '@tailwindcss/jit': {},
    autoprefixer: {},
    cssnano: process.env.NODE_ENV == 'production' ? {} : false
  }
}
