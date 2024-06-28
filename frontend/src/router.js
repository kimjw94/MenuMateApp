import { createWebHistory, createRouter } from "vue-router";

import Home from "./components/Home/Home.vue";
import Admin from "./components/Admin.vue";
import Pos from "./components/Pos.vue";
import Menu from "./components/Menu.vue";

const routes = [
    {
        path: "/",
        component: Home,
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