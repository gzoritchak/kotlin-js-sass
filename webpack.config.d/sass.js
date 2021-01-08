config.module.rules.push({
    test: /\.(scss|sass)$/,
    use: [
        /**
         *  fallback to style-loader in development
         *  "style-loader" creates style nodes from JS strings
         */
        // process.env.NODE_ENV !== 'production' ? 'style-loader' : MiniCssExtractPlugin.loader,
        // MiniCssExtractPlugin.loader,
        "style-loader",   // translates CSS into CommonJS
        "css-loader",   // translates CSS into CommonJS
        "sass-loader"   // compiles Sass to CSS, using Node Sass by default
    ]
});

