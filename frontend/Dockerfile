FROM node:16-alpine AS builder
WORKDIR /usr/app
COPY package.json .
COPY yarn.lock .
RUN yarn install
COPY . .
RUN yarn build
RUN yarn install --production

FROM node:16-alpine
WORKDIR /usr/app
COPY --from=builder /usr/app/package.json ./package.json
COPY --from=builder /usr/app/yarn.lock ./yarn.lock
COPY --from=builder /usr/app/.next ./.next
COPY --from=builder /usr/app/next.config.js ./next.config.js
COPY --from=builder /usr/app/node_modules ./node_modules

EXPOSE 3000
CMD ["yarn", "start"]
