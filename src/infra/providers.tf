provider "heroku" {
  api_key = var.api_key
}

provider "github" {
  token = var.github_token
  owner = "ticketsyncs"
}

provider "aws" {
  access_key = var.aws_access_key
  secret_key = var.aws_secret_key
  region = "us-east-1"
}

variable "api_key" {
  default = ""
}

variable "github_token" {
  default = ""
}

variable "aws_access_key" {
  default = ""
}

variable "aws_secret_key" {
  default = ""
}