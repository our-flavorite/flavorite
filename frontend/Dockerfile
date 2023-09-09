# install dependencies and build
FROM node:16-alpine AS builder
WORKDIR /app
COPY package.json .
COPY yarn.lock .
RUN yarn install
COPY . .
RUN yarn build
RUN yarn install --production

# run
FROM node:16-alpine
WORKDIR /app
COPY --from=builder /app/.next ./.next
COPY --from=builder /app/node_modules ./node_modules
COPY --from=builder /app/package.json ./
EXPOSE 3000
CMD ["yarn", "start"]
