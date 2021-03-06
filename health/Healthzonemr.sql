USE [master]
GO
/****** Object:  Database [Healthzonemr]    Script Date: 07-02-2021 20:56:55 ******/
CREATE DATABASE [Healthzonemr]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Healthzonemr', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Healthzonemr.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Healthzonemr_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Healthzonemr_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Healthzonemr] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Healthzonemr].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Healthzonemr] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Healthzonemr] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Healthzonemr] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Healthzonemr] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Healthzonemr] SET ARITHABORT OFF 
GO
ALTER DATABASE [Healthzonemr] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Healthzonemr] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Healthzonemr] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Healthzonemr] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Healthzonemr] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Healthzonemr] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Healthzonemr] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Healthzonemr] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Healthzonemr] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Healthzonemr] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Healthzonemr] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Healthzonemr] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Healthzonemr] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Healthzonemr] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Healthzonemr] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Healthzonemr] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Healthzonemr] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Healthzonemr] SET RECOVERY FULL 
GO
ALTER DATABASE [Healthzonemr] SET  MULTI_USER 
GO
ALTER DATABASE [Healthzonemr] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Healthzonemr] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Healthzonemr] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Healthzonemr] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Healthzonemr] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Healthzonemr] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Healthzonemr', N'ON'
GO
ALTER DATABASE [Healthzonemr] SET QUERY_STORE = OFF
GO
USE [Healthzonemr]
GO
/****** Object:  Table [dbo].[Message]    Script Date: 07-02-2021 20:56:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Message](
	[From_Msg] [varchar](100) NULL,
	[To_Msg] [varchar](100) NULL,
	[Message] [varchar](max) NULL,
	[MessageDate] [varchar](100) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Userreg]    Script Date: 07-02-2021 20:56:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Userreg](
	[Firstname] [varchar](50) NULL,
	[Lastname] [varchar](50) NULL,
	[Email] [varchar](50) NULL,
	[Password] [varchar](50) NULL,
	[Mobile] [varchar](50) NULL,
	[ID] [nvarchar](100) NULL,
	[Usertype] [varchar](50) NULL
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [Healthzonemr] SET  READ_WRITE 
GO
