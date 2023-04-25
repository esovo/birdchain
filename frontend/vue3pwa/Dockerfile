 # Base image
FROM node:18.16.0-alpine 

# Set working directory
WORKDIR /app_front

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy project files
COPY . .

# Build the project
RUN npm run build

# Set the command to run on container start
CMD ["npm", "run", "serve"]