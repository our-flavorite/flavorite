const nextConfig = {
  reactStrictMode: true, // strictMode 사용을 권장하지만, 로컬에서 이슈가 생길 경우 해당 옵션 끌 것
  swcMinify: true,
  webpack: config => {
    config.module.rules.push({
      test: /\.svg$/,
      use: ['@svgr/webpack'],
    })
    return config
  },
}

module.exports = nextConfig
