<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Java Mail</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            color: #333;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }
        .email-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 4px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        .email-header {
            text-align: center;
            padding: 20px 0;
            border-bottom: 1px solid #ddd;
        }
        .email-header h1 {
            font-size: 24px;
            color: #333;
        }
        .email-content {
            padding: 20px;
        }
        .email-content p {
            line-height: 1.5;
            margin: 0 0 10px;
        }
        .email-footer {
            text-align: center;
            padding: 20px 0;
            border-top: 1px solid #ddd;
        }
    </style>
</head>

<body>
    <div class="email-container">
        <div class="email-header">
            <h1>VS-13 - PessoaAPI</h1>
        </div>
        <div class="email-content">
            <p><b>Olá, ${nome}</b></p>
            <p>Seus dados foram editados com sucesso. Aqui estão os seus novos dados:</p>
            <p>ID: ${idPessoa}</p>
            <p>Nome: ${nome}</p>
            <p>Data de Nascimento: ${dataNascimento}</p>
            <p>CPF: ${cpf}</p>
            <p>Email: ${email}</p>

            <p>Se você não solicitou essa alteração, entre em contatoEntity com o suporte no email ${usernameEmail} imediatamente.</p>

            <p>Atenciosamente,</p>
            <p>Sistema</p>
        </div>
        <div class="email-footer">
            <p>© 2023 DBC Company. All rights reserved.</p>
        </div>
    </div>
</body>
</html>