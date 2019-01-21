const path = require('path');

module.exports = {
  context: path.resolve(__dirname, 'front'),
  entry: {
    home: './App.js',
    main: './main.js'
  },
  output: {
    path: path.resolve(__dirname, 'webapp/resources'),
    filename: '[name].js',
    publicPath: '/resources',
  },
  module: {
      rules: [
          {
              test: /\.js$/,
              use: {
                  loader: 'babel-loader',
                  options: {
                    presets: ['@babel/react', '@babel/env']
                  }
                },
              exclude: /node_modules/,
          },
          {
              test: /\.css$/,
              loader: 'style-loader!css-loader'
          },
          {
            test: /\.(gif|svg|jpg|png)$/,
            loader: "file-loader",
          }
      ]
  }
};