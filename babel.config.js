module.exports = {
    sourceMap: "inline",
    retainLines: true,
    presets: [
        [
            "@babel/preset-env",
            {
                targets: {
                    node: "current"
                }
            }
        ]
    ]
};
