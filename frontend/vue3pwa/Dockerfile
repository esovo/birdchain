# 1단계: 빌드용 이미지
FROM node:18.16.0-alpine AS build

# 작업 디렉토리 설정
WORKDIR /app_front

# package.json과 package-lock.json 복사
COPY package*.json ./

# 종속성 설치
RUN npm install

# 프로젝트 파일 복사
COPY . .

# 프로젝트 빌드
RUN npm run build

# 2단계: 실행용 이미지
FROM nginx:stable-alpine

# 빌드 결과물을 Nginx로 복사
COPY --from=build /app_front/dist /usr/share/nginx/html

# Nginx 포트 설정
EXPOSE 80

# Nginx 실행
CMD ["nginx", "-g", "daemon off;"]
