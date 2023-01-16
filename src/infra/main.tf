terraform {
  backend "s3" {
    bucket = "aliaksei-bialiauski-ticketsyncs-clockfarm-tfstate"
    key    = "dev/terraform.tfstate"
    region = "us-east-1"
  }
  required_providers {
    heroku = {
      source  = "heroku/heroku"
      version = "5.1.10"
    }
    aws = {
      source  = "hashicorp/aws"
      version = "4.50.0"
    }
  }
}