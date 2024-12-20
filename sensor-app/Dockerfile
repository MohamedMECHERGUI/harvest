FROM node:21

RUN npm install -g @angular/cli
WORKDIR /src/app

COPY package.json ./
RUN npm install
COPY . .
RUN npm run build

CMD ng serve --host 0.0.0.0 --port 4200

EXPOSE 4200
