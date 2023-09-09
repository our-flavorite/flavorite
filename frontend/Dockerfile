# install dependencies
FROM node:16-alpine AS deps
WORKDIR /app
COPY package.json .
COPY yarn.lock .
RUN yarn install
# build
FROM node:16-alpine AS builder
WORKDIR /app
COPY --from=deps /app/node_modules ./node_modules
COPY src ./src
COPY pages ./pages
# COPY public ./public : public 디렉토리 생성 시 추가
COPY package.json next.config.js tsconfig.json yarn.lock ./
RUN yarn build
RUN yarn install --production
# run
FROM node:16-alpine
WORKDIR /app
COPY --from=builder /app/.next ./.next
# COPY --from=builder /app/public ./public
COPY --from=builder /app/node_modules ./node_modules
COPY --from=builder /app/package.json ./
EXPOSE 3000
CMD ["yarn", "start"]
