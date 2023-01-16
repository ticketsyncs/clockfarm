terraform {
  backend "s3" {
    bucket = "aliaksei-bialiauski-ticketsyncs-clockfarm-tfstate"
    key    = "dev/terraform.tfstate"
    region = "us-east-1"
  }
  required_providers {
    github = {
      source  = "integrations/github"
      version = "~> 4.0"
    }
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