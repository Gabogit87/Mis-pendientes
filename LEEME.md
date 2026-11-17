# Mis Pendientes — App Android

App para anotar pendientes por cliente (qué hacer, fecha de entrega, estado, cómo quedó),
con línea de tiempo de seguimientos y notificaciones en el celular.

## Cómo obtener el APK (sin instalar nada en tu PC)
1. Crea una cuenta en https://github.com (gratis) y un repositorio nuevo, por ejemplo `mis-pendientes`.
2. Sube el contenido de esta carpeta al repositorio (botón "Add file → Upload files", arrastra todo
   menos `node_modules`).
3. GitHub compila solo (pestaña **Actions**, tarda ~5 min).
4. En la pestaña **Releases** aparece `MisPendientes.apk`. Ábrelo desde el celular y descárgalo.

## Instalar en Android
- Abre el APK descargado → si pide "Permitir instalar apps de esta fuente", acepta.
- Al abrir la app, acepta las **notificaciones**.
- Si sale el aviso "Alarmas y recordatorios", toca **Dar permiso** (para que los avisos lleguen a la hora exacta).
- Recomendado: Ajustes del cel → Apps → Mis Pendientes → Batería → **Sin restricciones**.

## Notificaciones que manda
- Resumen diario (7:30 por defecto) con atrasados, los que vencen hoy y los sin seguimiento.
- El día anterior a la entrega (17:00) y el día de la entrega (08:00).
- Al día siguiente si quedó atrasado.
- Cuando un pendiente lleva X días sin seguimiento (3 por defecto).
Todo se ajusta en ⚙︎ dentro de la app.

## Para compilar en tu PC (opcional)
Requiere Node 22, JDK 21 y Android Studio:
    npm install
    npx cap sync android
    npx cap open android
