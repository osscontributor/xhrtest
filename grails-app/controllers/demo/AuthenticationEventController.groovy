package demo

class AuthenticationEventController {
    def index() {
        if(!request.xhr) {
            redirect(controller: "main")
        } else {
            render(template: "index")
        }
    }
}