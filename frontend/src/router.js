import { createWebHistory, createRouter } from "vue-router";

import Home from "./components/Home/Home.vue";
import Admin from "./components/Admin.vue";
import Pos from "./components/Pos.vue";
import Menu from "./components/Menu.vue";
import StartMenuMate from "./components/Home/StartMenuMate.vue";
import SignUpMenuMate from "./components/Home/SignUpMenuMate.vue";
import LoginMenuMate from "./components/Home/LoginMenuMate.vue";

const routes = [
    {
        path: "/",
        component: Home,
        children: [
            {
                path: "",
                component: StartMenuMate
            },
            {
                path: "signup",
                component: SignUpMenuMate
            },
            {
                path: "login",
                component: LoginMenuMate
            }
        ]
    },
    {
        path: "/admin",
        component: Admin,
    },
    {
        path: "/pos",
        component: Pos,
    },
    {
        path: "/menu",
        component: Menu,
    }
]

const router = createRouter({ history: createWebHistory(), routes });

export default router;