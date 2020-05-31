import React from 'react';
import styled from "styled-components";
import './SideNav.css'
import NavItem from "../items/NavItem";
import Pacienti from "../../pacienti/Pacienti";

const StyledSideNav = styled.div``;

class SideNav extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            activePath: '/',
            items: [
                {
                    path: '/', /* path is used as id to check which NavItem is active basically */
                    name: 'Home',
                    css: 'fa fa-fw fa-home',
                    key: 1, /* Key is required, else console throws error. Does this please you Mr. Browser?! */
                },
                {
                    path: '/about',
                    name: 'About',
                    css: 'fa fa-fw fa-clock',
                    key: 2,
                },
                {
                    path: '/pacienti',
                    name: 'Lista pacienti',
                    css: 'fas fa-archive',
                    key: 3,
                },
            ]
        }
    }

    onItemClick = (path) => {
        this.setState({activePath: path}); /* Sets activePath which causes rerender which causes CSS to change */
    };

    render() {
        const {items, activePath} = this.state;

        return (
            <StyledSideNav className='sideBar'>
                {
                    items.map((item) => {
                        return (
                            <NavItem path={item.path} name={item.name} css={item.css} onItemClick={this.onItemClick}
                                     active={item.path === activePath} key={item.key}/>
                        )
                    })
                }
            </StyledSideNav>
        );
    }
}

export default class Sidebar extends React.Component {
    render() {
        return (
            <SideNav></SideNav>
        );
    }
}
